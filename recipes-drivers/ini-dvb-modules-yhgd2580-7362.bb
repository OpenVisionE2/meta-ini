SUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE}"

KV = "3.14.2"
SRCDATE = "20160122"

PV = "${KV}+${SRCDATE}"

SRC_URI[md5sum] = "ae1311220a63da86e0f0c6ce53b017f0"
SRC_URI[sha256sum] = "68346874ec086d96f11e1bc2189337ec5c0ec86e6deb59a069c07e59b43882d4"

SRC_URI = "http://source.mynonpublic.com/ini/yhgd2580-7362-drivers-${KV}-${SRCDATE}.zip"

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
        install -m 0755 ${WORKDIR}/$i.ko ${D}/lib/modules/${KV}/extra/${i}_${MACHINE}.ko
        echo ${i}_${MACHINE} >> ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
    done
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf /lib/modules/${KV}/extra"
