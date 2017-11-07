BRANCH_vusolo4k = "Vu_HD_1080p"
BRANCH_vuultimo4k = "Vu_HD_1080p"
BRANCH_vuuno4k = "Vu_HD_1080p"
BRANCH_vuuno4kse = "Vu_HD_1080p"

PACKAGE_ARCH := "${MACHINE_ARCH}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " ${@base_conditional("MACHINE", "vuultimo4k", "file://remove_frontendinfo.patch", "", d)}"

