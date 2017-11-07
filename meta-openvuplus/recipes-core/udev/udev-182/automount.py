#!/usr/bin/python
import os
import sys

def readFile(fn):
	return open(fn, "r").read()

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

def automount():
	kernel = sys.argv[1]
	dev_kernel = os.path.join("/dev/", kernel)
	dev_index = os.path.basename(kernel)[-1]
	dev_base = os.path.basename(kernel)[:-1]
	removable=readFile("/sys/block/%s/removable" % dev_base).strip() == "1"
	dev_real_path = os.path.realpath("/sys/block/%s/device" % dev_base)
	external = False
	if (dev_real_path.find("pci") != -1) or (dev_real_path.find("ahci") != -1) or (dev_real_path.find("sata") != -1):
		external = True

	if isMountedByDevName(dev_kernel):
		return

	deviceType = "hdd"
#	if removable or external:
	if removable:
		deviceType = "usb"

	if dev_index == "1":
		mountPoint = "/media/" + deviceType

		if os.path.ismount(mountPoint):
			mountPoint = "/media/" + kernel

		elif not os.access(mountPoint, os.F_OK):
			os.mkdir(mountPoint)
			if not os.access(mountPoint, os.F_OK):
				mountPoint = "/media/" + kernel

	else:
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
