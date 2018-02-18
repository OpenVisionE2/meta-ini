SUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE}"

KV = "3.14.2"
SRCDATE = "20160122"

PV = "${KV}+${SRCDATE}"

SRC_URI[md5sum] = "5a95aef9199e78f1e89ee40a6c352f09"
SRC_URI[sha256sum] = "e9d9c4ebf2c8a360ad0d271801c819edb919f96d7f3f809c192c7339d10966ea"

SRC_URI = "http://source.mynonpublic.com/ini/ini-442dt-drivers-${KV}-${SRCDATE}.zip"

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
