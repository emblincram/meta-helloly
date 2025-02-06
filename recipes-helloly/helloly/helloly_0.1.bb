# SPDX-License-Identifier: MIT
# SPDX-Author: Roman Koch <koch.romam@gmail.com>
# SPDX-Copyright: 2024 Roman Koch <koch.romam@gmail.com>

SUMMARY = "Standalone C++ Anwendung für Yocto"
DESCRIPTION = "Ein extern entwickeltes C++-Programm, das mit CMake gebaut wird"

LICENSE = "MIT"
# bitbake -e | grep ^COMMON_LICENSE_DIR
# md5sum LICENSE
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*  Example recipe created by bitbake-layers   *");
    bb.plain("***********************************************");
}

addtask display_banner before do_build

# Hier wird das externe Repository eingebunden
SRC_URI = "git://github.com/emblincram/helloly.git;branch=main;protocol=ssh"
#SRC_URI = "https://github.com/emblincram/helloly.git;branch=main;protocol=https"
#SRC_URI = "git://github.com/emblincram/helloly.git;branch=main;protocol=https;user=emblincram;pass=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"
#SRCREV = "${AUTOREV}"
SRCREV = "5f4ad45f27e937c5462d7bf60d8cd89d385a1d21"

S = "${WORKDIR}/git"

DEPENDS = "cmake"

inherit cmake

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/helloly ${D}${bindir}/helloly
}
