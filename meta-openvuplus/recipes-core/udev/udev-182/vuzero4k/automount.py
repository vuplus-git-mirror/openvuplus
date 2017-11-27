#!/usr/bin/python
import os
import sys
import glob

def readFile(fn):
	return open(fn, "r").read()

def getLabelFromDevName(dev_kernel):
	data = None
	try:
		data = os.popen("e2label %s" % dev_kernel).read().strip()
		if not data: 
			data = None
	except:
		data = None

	return data

def getModel(dev_base):
	model = None
	modelpath = "/sys/block/%s/device/model" % dev_base
	if os.access(modelpath, os.F_OK):
		model = open(modelpath, "r").read().strip().replace(' ','-')
	return model

def isMountedByDevName(devName):
	ismounted = False
	mounts = file('/proc/mounts').read().split('\n')
	for x in mounts:
		if not x.startswith('/'):
			continue

		devpath, mountpoint  = x.split()[:2]
		if devpath == devName:
			ismounted = True
			break

	return ismounted

def isUsbDevice(dev_base):
	phyPath = os.path.realpath('/sys/block/' + dev_base)
	for x in glob.glob("/sys/bus/usb/devices/usb*"):
		if phyPath.find(os.path.realpath(x)) != -1:
			return True
	return False

def automount():
	kernel = sys.argv[1]
	dev_kernel = os.path.join("/dev/", kernel)
	dev_index = os.path.basename(kernel)[-1]
	dev_base = os.path.basename(kernel)[:-1]
	removable=readFile("/sys/block/%s/removable" % dev_base).strip() == "1"
	dev_real_path = os.path.realpath("/sys/block/%s/device" % dev_base)

	if isMountedByDevName(dev_kernel):
		return

	mountPoint = None
	if dev_index == "1":
		if dev_real_path.find("f0b00500.ehci_v2/usb2/2-1") != -1:
			mountPoint = "/media/hdd"

	if (mountPoint == None) or (os.path.ismount(mountPoint)):
		label = getLabelFromDevName(dev_kernel)
		if label:
			mountPoint = "/media/" + label
			if dev_index and dev_index != '1':
				mountPoint += "_%s" % dev_index

	if (mountPoint == None) or (os.path.ismount(mountPoint)):
		model = getModel(dev_base)
		if model:
			mountPoint = "/media/" + model
			if dev_index and dev_index != '1':
				mountPoint += "_%s" % dev_index

	if (mountPoint == None) or (os.path.ismount(mountPoint)):
		mountPoint = "/media/" + kernel

	if not os.access(mountPoint, os.F_OK):
		os.mkdir(mountPoint)
		if not os.access(mountPoint, os.F_OK):
			return

	if os.system("mount -t auto -o noatime %s %s" % (dev_kernel, mountPoint)):
		os.rmdir(mountPoint)
	else:
		if mountPoint == "/media/hdd":
			defaultMoviePath = "/media/hdd/movie"
			if not os.access(defaultMoviePath, os.F_OK):
				os.mkdir(defaultMoviePath)

if __name__=="__main__":
	automount()
