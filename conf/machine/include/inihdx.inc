require conf/machine/include/ini-oem.inc

MTD_KERNEL = "mtd1"
MTD_ROOTFS = "mtd2"

PREFERRED_PROVIDER_virtual/kernel = "linux-ini-hdx"
PREFERRED_VERSION_linux-ini-hdx = "3.6.0"

MACHINE_FEATURES += "textlcd fanctrl extrasplash blindscan-dvbc blindscan-dvbs ci dvb-c SCART YUV"

SOC_FAMILY = "bcm7413"

UBI_VOLNAME = "rootfs"
MKUBIFS_ARGS = "-m 2048 -e 126976 -c 4096"
UBINIZE_ARGS = "-m 2048 -p 128KiB"

MACHINE_EXTRA_RRECOMMENDS += "\
    ini-cfe \
    "

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    ini-dvb-modules-inihdx \
    "

STB_PLATFORM = "inihdx"