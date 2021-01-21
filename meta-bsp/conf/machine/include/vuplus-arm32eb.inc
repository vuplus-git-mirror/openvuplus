# vuplus-arm32eb.inc

VUPLUS_KERNEL_VERSION ?= "3.14.28"

#Big Endian
#TARGET_ARCH = "armeb"
#DEFAULTTUNE = "armv7ab"

#Little Endian
TARGET_ARCH = "arm"

#DEFAULTTUNE = "armv7a"
#DEFAULTTUNE = "armv7ahf"
DEFAULTTUNE = "armv7ahf-neon"

require conf/machine/include/vuplus.inc
require conf/machine/include/arm/arch-armv7a.inc

VUPLUS_FEATURES += "turbo2"
