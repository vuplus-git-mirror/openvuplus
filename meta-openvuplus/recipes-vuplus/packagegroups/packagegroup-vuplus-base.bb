SUMMARY = "Vuplus: Base set of packages for Vuplus."
SECTION = "vuplus/base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
PR = "r7"

inherit packagegroup

VUPLUS_BASE_ESSENTIAL = "\
    autofs \
    procps \
    vuplus-compat \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    e2fsprogs-tune2fs \
    fakelocale \
    opkg \
    tzdata \
    tuxbox-common \
    util-linux-sfdisk \
    vsftpd \
    mtd-utils-mkfs.ubifs \
    mtd-utils-mkfs.jffs2 \
    mtd-utils-nandwrite \
    mtd-utils-nanddump \
    mtd-utils-flash-eraseall \
    mtd-utils-flash-erase \
    mtd-utils-ubinize \
    mtd-utils-ubiformat \
    mtd-utils-ubiattach \
    mtd-utils-ubidetach \
    mtd-utils-ubimkvol \
    hdparm \
    gptfdisk \
    usbtunerhelper \
    killall \
    openresolv \
    module-init-tools \
    ${@base_contains("VUPLUS_FEATURES", "dvbproxy", "vuplus-dvb-proxy libgles vuplus-platform-util", "vuplus-dvb-modules", d)} \
"

VUPLUS_FIRMWARE_DVB = " \
    firmware-dvb-af9005 \
    firmware-dvb-fe-af9013 \
    firmware-dvb-usb-af9015 \
    firmware-dvb-usb-af9035 \
    firmware-dvb-usb-avertv-a800 \
    firmware-dvb-usb-dib0700 \
    firmware-dvb-usb-dibusb \
    firmware-dvb-usb-digitv \
    firmware-dvb-usb-nova-t-usb2 \
    firmware-dvb-usb-sms1xxx-nova-dvbt \
    firmware-dvb-usb-sms1xxx-hcw-dvbt \
    firmware-dvb-usb-ttusb-budget \
    firmware-dvb-usb-umt-010 \
    firmware-dvb-usb-xc5000 \
    firmware-dvb-usb-wt220u-zl0353 \
    firmware-drxd-a2 \
"

VUPLUS_BASE_RECOMMENDS = "\
    dropbear \
    sambaserver \
    openvpn \
    zeroconf \
    ${@base_contains("VUPLUS_FEATURES", "vuplus-fpga-update", "vuplus-fpga-update", "", d)} \
    ${@base_contains("VUPLUS_FEATURES", "wol", "vuplus-coldboot", "", d)} \
    ${@base_contains("VUPLUS_FEATURES", "wowl", "vuplus-wowl", "", d)} \
"

VUPLUS_BASE_OPTIONAL_RECOMMENDS = "\
    hddtemp \
    joe \
    mc \
    ncdu \
    ppp \
    smartmontools \
    avahi-daemon \
    curlftpfs \
"

RDEPENDS_${PN} += "\
    ${VUPLUS_BASE_ESSENTIAL} \
    ${VUPLUS_FIRMWARE_DVB} \
"

RRECOMMENDS_${PN} += "\
    ${VUPLUS_BASE_RECOMMENDS} \
    ${VUPLUS_BASE_OPTIONAL_RECOMMENDS} \
"
