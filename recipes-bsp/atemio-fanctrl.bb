PV = "1.0"

require conf/license/openpli-gplv2.inc

SRC_URI = "file://fancontrol.tar.gz"

do_install() {
    install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions
    cp -r ${WORKDIR}/usr/lib/enigma2/python/Plugins/Extensions/FanControl ${D}/usr/lib/enigma2/python/Plugins/Extensions/
}

FILES_${PN} = "/usr/lib/enigma2/python/Plugins/Extensions/FanControl"

PACKAGE_ARCH = "${MACHINE_ARCH}"

