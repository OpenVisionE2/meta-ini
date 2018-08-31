SUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE}"

COMPATIBLE_MACHINE = "xpeedlx3|sezammarvel"

KV = "3.14.2"
SRCDATE = "20160121"

PV = "${KV}+${SRCDATE}"

SRC_URI[md5sum] = "0c851b0d74f121144932cae1292b6dbc"
SRC_URI[sha256sum] = "302ca4ed31ff8655115b7d2e8e945cc4e0a212b656413d647524f98f38df6917"

SRC_URI = "http://source.mynonpublic.com/ini/ini-900-drivers-${KV}-${SRCDATE}.zip"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

do_compile() {
}
do_populate_sysroot() {
}

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -d ${D}/${sysconfdir}/modules-load.d
    for i in dvb; do
        install -m 0755 ${WORKDIR}/$i.ko ${D}/lib/modules/${KV}/extra/$i.ko
        echo $i >> ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
    done
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf /lib/modules/${KV}/extra"
