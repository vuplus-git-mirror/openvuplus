#!/usr/bin/python
import os
import sys

def getMountPoint(devName):
	mounts = file('/proc/mounts').read().split('\n')
	for x in mounts:
		if not x.startswith('/'):
			continue

		devpath, mountpoint  = x.split()[:2]
		if devpath == devName:
			return mountpoint

	return None

def autoumount():
	kernel = sys.argv[1]
	dev_kernel = os.path.join("/dev/", kernel)

	mountPoint = getMountPoint(dev_kernel)
	if mountPoint is None:
		mountPoint = os.path.join("/media/", kernel)

	if os.system("umount %s" % mountPoint):
		os.system("umount %s" % os.path.join("/dev/", kernel))

	try:
		os.rmdir(mountPoint)
	except:
		pass

if __name__=="__main__":
	autoumount()

