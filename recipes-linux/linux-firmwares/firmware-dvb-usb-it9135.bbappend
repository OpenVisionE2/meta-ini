FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_mbultra += "\
    file://dvb-usb-it9135-02.fw \
"

do_install_append_mbultra() {
	install -m 0644 dvb-usb-it9135-02.fw ${D}${base_libdir}/firmware
}
