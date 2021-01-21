SUMMARY = "Vuplus: Essential packages"
SECTION = "vuplus/base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DEPENDS = "virtual/kernel"

RDEPENDS_${PN} = '${ESSENTIAL_RDEPENDS}'
RRECOMMENDS_${PN} = '${ESSENTIAL_RRECOMMENDS}'
RRECOMMENDS_${PN} += '${KERNEL_DVB_MODULES}'

PR = "r10"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

ESSENTIAL_RDEPENDS = " \
	vuplus-tuner-turbo \
	${@base_contains("VUPLUS_FEATURES", "turbo2", "vuplus-tuner-turbo2", "", d)} \
"

KERNEL_FS_MODULES = " \
        kernel-module-ext2 \
        kernel-module-ext4 \
        kernel-module-autofs4 \
        kernel-module-cifs \
        kernel-module-msdos \
        kernel-module-udf \
        kernel-module-isofs \
        kernel-module-nls-cp850 \
"

ESSENTIAL_RRECOMMENDS = " \
        kernel-module-cdrom \
        kernel-module-sr-mod \
	${KERNEL_FS_MODULES} \
"

DVB_USB_V1 = " \
  kernel-module-dvb-usb \
  kernel-module-dvb-usb-a800 \
  kernel-module-dvb-usb-dibusb-common \
  kernel-module-dvb-usb-dibusb-mb \
  kernel-module-dvb-usb-dibusb-mc \
  kernel-module-dvb-usb-dib0700 \
  kernel-module-dvb-usb-umt-010 \
  kernel-module-dvb-usb-cxusb \
  kernel-module-dvb-usb-m920x \
  kernel-module-dvb-usb-digitv \
  kernel-module-dvb-usb-vp7045 \
  kernel-module-dvb-usb-vp702x \
  kernel-module-dvb-usb-gp8psk \
  kernel-module-dvb-usb-nova-t-usb2 \
  kernel-module-dvb-usb-ttusb2 \
  kernel-module-dvb-usb-dtt200u \
  kernel-module-dvb-usb-opera \
  kernel-module-dvb-usb-af9005 \
  kernel-module-dvb-usb-af9005-remote \
  kernel-module-dvb-usb-pctv452e \
  kernel-module-dvb-usb-dw2102 \
  kernel-module-dvb-usb-cinergyt2 \
  kernel-module-dvb-usb-dtv5100 \
  kernel-module-dvb-usb-friio \
  kernel-module-dvb-usb-az6027 \
  kernel-module-dvb-usb-technisat-usb2 \
"

DVB_USB_V2 = " \
  kernel-module-dvb-usb-v2 \
  kernel-module-dvb-usb-af9015 \
  kernel-module-dvb-usb-af9035 \
  kernel-module-dvb-usb-anysee \
  kernel-module-dvb-usb-au6610 \
  kernel-module-dvb-usb-az6007 \
  kernel-module-dvb-usb-ce6230 \
  kernel-module-dvb-usb-ec168 \
  kernel-module-dvb-usb-gl861 \
  kernel-module-dvb-usb-it913x \
  kernel-module-dvb-usb-lmedm04 \
  kernel-module-dvb-usb-mxl111sf \
  kernel-module-mxl111sf-demod \
  kernel-module-mxl111sf-tuner \
  kernel-module-dvb-usb-rtl28xxu \
"

KERNEL_MEDIA_ANALOG_USB_ADAPTERS = " \
  kernel-module-pvrusb2 \
  kernel-module-hdpvr \
  kernel-module-usbvision \
  kernel-module-stk1160 \
  kernel-module-poseidon \
"

KERNEL_MEDIA_ANALOG_DIGITAL_USB_ADAPTERS = " \
  kernel-module-au0828 \
  kernel-module-cx231xx \
  kernel-module-tm6000 \
  kernel-module-em28xx \
"

KERNEL_MEDIA_USB_ADAPTERS = " \
  kernel-module-au0828 \
  ${DVB_USB_V1} \
  ${DVB_USB_V2} \
  kernel-module-dvb-ttusb-budget \
  kernel-module-smsusb \
  kernel-module-smsdvb \
  kernel-module-smsmdtv \
  kernel-module-b2c2-flexcop \
  kernel-module-b2c2-flexcop-usb \
  kernel-module-tveeprom \
  kernel-module-cypress-firmware \
  kernel-module-dvb-usb-cypress-firmware \
  ${KERNEL_MEDIA_ANALOG_USB_ADAPTERS} \
  ${KERNEL_MEDIA_ANALOG_DIGITAL_USB_ADAPTERS} \
"

KERNEL_MEDIA_CUSTOMIZE_TV_TUNER = " \
  kernel-module-tuner-simple \
  kernel-module-tuner-types \
  kernel-module-tda8290 \
  kernel-module-tda827x \
  kernel-module-tda18271 \
  kernel-module-tda9887 \
  kernel-module-tea5761 \
  kernel-module-tea5767 \
  kernel-module-mt20xx \
  kernel-module-mt2060 \
  kernel-module-mt2063 \
  kernel-module-mt2266 \
  kernel-module-mt2131 \
  kernel-module-qt1010 \
  kernel-module-tuner-xc2028 \
  kernel-module-xc5000 \
  kernel-module-xc4000 \
  kernel-module-mxl5005s \
  kernel-module-mxl5007t \
  kernel-module-mc44s803 \
  kernel-module-max2165 \
  kernel-module-tda18218 \
  kernel-module-fc0011 \
  kernel-module-fc0012 \
  kernel-module-fc0013 \
  kernel-module-tda18212 \
  kernel-module-e4000 \
  kernel-module-fc2580 \
  kernel-module-tua9001 \
  kernel-module-tuner-it913x \
  kernel-module-r820t \
"

KERNEL_MEDIA_CUSTOMIZE_DVB_FRONTENDS = " \
  kernel-module-stb0899 \
  kernel-module-stb6100 \
  kernel-module-stv090x \
  kernel-module-stv6110x \
  kernel-module-drxk \
  kernel-module-tda18271c2dd \
  kernel-module-cx24110 \
  kernel-module-cx24123 \
  kernel-module-mt312 \
  kernel-module-zl10036 \
  kernel-module-zl10039 \
  kernel-module-s5h1420 \
  kernel-module-stv0288 \
  kernel-module-stb6000 \
  kernel-module-stv0299 \
  kernel-module-stv6110 \
  kernel-module-stv6110x \
  kernel-module-stv0900 \
  kernel-module-tda8083 \
  kernel-module-tda10086 \
  kernel-module-tda8261 \
  kernel-module-ves1x93 \
  kernel-module-itd1000 \
  kernel-module-cx24113 \
  kernel-module-tda826x \
  kernel-module-tua6100 \
  kernel-module-cx24116 \
  kernel-module-cx24117 \
  kernel-module-si21xx \
  kernel-module-ts2020 \
  kernel-module-ds3000 \
  kernel-module-mb86a16 \
  kernel-module-tda10071 \
  kernel-module-sp8870 \
  kernel-module-sp887x \
  kernel-module-cx22700 \
  kernel-module-cx22702 \
  kernel-module-s5h1432 \
  kernel-module-drxd \
  kernel-module-l64781 \
  kernel-module-tda1004x \
  kernel-module-nxt6000 \
  kernel-module-mt352 \
  kernel-module-zl10353 \
  kernel-module-dib3000mb \
  kernel-module-dib3000mc \
  kernel-module-dib7000m \
  kernel-module-dib7000p \
  kernel-module-dib9000 \
  kernel-module-tda10048 \
  kernel-module-af9013 \
  kernel-module-ec100 \
  kernel-module-hd29l2 \
  kernel-module-stv0367 \
  kernel-module-cxd2820r \
  kernel-module-rtl2830 \
  kernel-module-rtl2832 \
  kernel-module-ves1820 \
  kernel-module-tda10021 \
  kernel-module-tda10023 \
  kernel-module-stv0297 \
  kernel-module-s921 \
  kernel-module-dib8000 \
  kernel-module-mb86a20s \
  kernel-module-dvb-pll \
  kernel-module-dib0070 \
  kernel-module-dib0090 \
  kernel-module-lnbp21 \
  kernel-module-lnbp22 \
  kernel-module-isl6405 \
  kernel-module-isl6421 \
  kernel-module-isl6423 \
  kernel-module-a8293 \
  kernel-module-lgs8gl5 \
  kernel-module-lgs8gxx \
  kernel-module-atbm8830 \
  kernel-module-tda665x \
  kernel-module-ix2505v \
  kernel-module-it913x-fe \
  kernel-module-m88rs2000 \
  kernel-module-af9033 \
"

EXTRA_DRIVERS = " \
  ${@base_conditional("TARGET_ARCH", "mipsel", "hmp-usb-dvb-t2-c", "hmp-usb-dvb-t2-c-arm", d)} \
"

KERNEL_DVB_MODULES = " \
  ${KERNEL_MEDIA_USB_ADAPTERS} \
  ${KERNEL_MEDIA_CUSTOMIZE_TV_TUNER} \
  ${KERNEL_MEDIA_CUSTOMIZE_DVB_FRONTENDS} \
  ${EXTRA_DRIVERS} \
"

