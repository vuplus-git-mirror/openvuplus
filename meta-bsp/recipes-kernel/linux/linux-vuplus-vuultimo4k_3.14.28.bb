require linux-vuplus-3.14.28.inc

COMPATIBLE_MACHINE = "^(vuultimo4k)$"

PR = "${INC_PR}.10"

SRC_URI = "http://archive.vuplus.com/download/kernel/stblinux-3.14-1.12.tar.bz2 \
    file://${KERNEL_CONFIG} \
    file://bcm_genet_disable_warn.patch \
    file://linux_dvb-core.patch \
    file://rt2800usb_fix_warn_tx_status_timeout_to_dbg.patch \
    file://usb_core_hub_msleep.patch \
    file://bcmsysport_3.14.28-1.12.patch \
    file://linux_prevent_usb_dma_from_bmem.patch \
    "

SRC_URI += "${@base_contains("VUPLUS_FEATURES", "dvbproxy", "file://linux_dvb_adapter.patch;patch=1;pnum=1", "", d)}"

SRC_URI[md5sum] = "2a3a0a7e5cd2a1392f1a26790d1cd8bf"
SRC_URI[sha256sum] = "8284670c28a4dad9e94752b38d37a4368f27ce15e671653a3e2ac83915f37db1"


