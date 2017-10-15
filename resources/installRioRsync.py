#!/usr/bin/env python2
import subprocess as sp
import argparse

def install(ssh_target, pkg):
    """Installs a package from NI on the ssh target."""
    print("Installing", pkg)
    PKG_URL = 'http://download.ni.com/ni-linux-rt/feeds/2015/arm/ipk/cortexa9-vfpv3/' + pkg
    sp.check_call(['wget', PKG_URL, '-O', pkg])
    try:
        sp.check_call(['scp', pkg, ssh_target + ':/tmp/' + pkg])
        sp.check_call(['ssh', ssh_target, 'opkg', 'install', '/tmp/' + pkg])
        sp.check_call(['ssh', ssh_target, 'rm', '/tmp/' + pkg])
    finally:
        sp.check_call(['rm', pkg])

parser = argparse.ArgumentParser()
parser.add_argument('REMOTE', help="The ssh remote to install rsync on")
args = parser.parse_args()
install(args.REMOTE, 'libattr1_2.4.47-r0.36_cortexa9-vfpv3.ipk')
install(args.REMOTE, 'libacl1_2.2.52-r0.36_cortexa9-vfpv3.ipk')
install(args.REMOTE, 'rsync_3.1.0-r0.7_cortexa9-vfpv3.ipk')
