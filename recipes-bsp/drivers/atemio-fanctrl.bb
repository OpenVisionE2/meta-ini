PV = "1.0"

require conf/license/openvision-gplv2.inc

SRC_URI = "file://fancontrol.tar.gz"

do_install() {
    install -d ${D}${libdir}/enigma2/python/Plugins/Extensions
    cp -r ${WORKDIR}${libdir}/enigma2/python/Plugins/Extensions/FanControl ${D}${libdir}/enigma2/python/Plugins/Extensions/
}

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/FanControl"

PACKAGE_ARCH = "${MACHINE_ARCH}"

