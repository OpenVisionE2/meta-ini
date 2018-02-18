SUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE}"

KV = "3.14.2"
SRCDATE = "20160122"

PV = "${KV}+${SRCDATE}"

SRC_URI[md5sum] = "0fdcd091fc5657b14fa953e28aca6f5f"
SRC_URI[sha256sum] = "f664e8503e463fc0a2201f0596eab3fca7a3c1fe5faf8e91cd2a8d26b977c27c"

SRC_URI = "http://source.mynonpublic.com/ini/ini-422sv-drivers-${KV}-${SRCDATE}.zip"

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
