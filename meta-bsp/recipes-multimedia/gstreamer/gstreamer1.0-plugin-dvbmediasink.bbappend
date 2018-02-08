FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR .= "-bsp2"

SRC_URI_append_vuuno4k = " file://dvbvideosink_vp9.patch"
SRC_URI_append_vuultimo4k = " file://dvbvideosink_vp9.patch"
SRC_URI_append_vuuno4kse = " file://dvbvideosink_vp9.patch"
SRC_URI_append_vuzero4k = " file://dvbvideosink_vp9.patch"

EXTRA_OECONF_append_vusolo4k = " --with-dtsdownmix --with-dts=yes"
EXTRA_OECONF_append_vuuno4k = " --with-vb9 --with-dtsdownmix --with-dts=yes"
EXTRA_OECONF_append_vuultimo4k = " --with-vb9 --with-dtsdownmix --with-dts=yes"
EXTRA_OECONF_append_vuuno4kse = " --with-vb9 --with-dtsdownmix --with-dts=yes"
EXTRA_OECONF_append_vuzero4k = " --with-vb9 --with-dtsdownmix --with-dts=yes"
