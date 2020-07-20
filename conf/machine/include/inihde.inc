require conf/machine/include/ini-oem.inc

MTD_KERNEL = "mtd2"
MTD_ROOTFS = "mtd0"

PREFERRED_PROVIDER_virtual/kernel = "linux-ini-hde"
PREFERRED_VERSION_linux-ini-hde2 = "3.12.1"

MACHINE_FEATURES += "videoenhancement extrasplash blindscan-tbs blindscan-dvbs blindscan-dvbc dvb-c ci"

SOC_FAMILY = "bcm7358"

UBI_VOLNAME = "rootfs"
MKUBIFS_ARGS = "-m 2048 -e 126976 -c 4096"
UBINIZE_ARGS = "-m 2048 -p 128KiB"

MACHINE_EXTRA_RRECOMMENDS += "\
    ini-cfe \
    "

STB_PLATFORM = "inihde"
