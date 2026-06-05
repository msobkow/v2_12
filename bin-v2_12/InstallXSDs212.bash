#!/bin/bash
if [ ! -d ~/bin ]; then
	mkdir ~/bin
fi
if [ ! -d ~/bin/bin ]; then
	mkdir ~/bin/bin
fi
if [ ! =d ~/bin/bin/xsd ]; then
	mkdir ~/bin/bin/xsd
fi
if [ ! -d /usr/share/xsd ]; then
	sudo mkdir /usr/share/xsd
	sudo chmod 755 /usr/share/xsd
fi
cd $MSSCFHOME
pushd $MSSCFHOME/cflib_2_12/java/
cd bin
cd xsd
cp -v cftip-*.xsd ~/bin/bin/xsd
chmod 644 ~/bin/bin/xsd/cftip-*.xsd
sudo cp -v cftip-*.xsd /usr/share/xsd
sudo chmod 644 /usr/share/xsd/cftip-*.xsd
popd
#
pushd $MSSCFHOME/cfcore_2_12/java/
cd bin
cd xsd
cp -v cfgenkb-*.xsd ~/bin/bin/xsd
chmod 644 ~/bin/bin/xsd/cfgenkb-*.xsd
sudo cp -v cfgenkb-*.xsd /usr/share/xsd
sudo chmod 644 /usr/share/xsd/cfgenkb-*.xsd
popd
#
pushd $MSSCFHOME/cfsec_2_12/java/
cd bin
cd xsd
cp -v cfsec-*.xsd ~/bin/bin/xsd
chmod 644 ~/bin/bin/xsd/cfsec-*.xsd
sudo cp -v cfsec-*.xsd /usr/share/xsd
sudo chmod 644 /usr/share/xsd/cfsec-*.xsd
popd
#
pushd $MSSCFHOME/cfint_2_12/java/
cd bin
cd xsd
cp -v cfint-*.xsd ~/bin/bin/xsd
chmod 644 ~/bin/bin/xsd/cfint-*.xsd
sudo cp -v cfint-*.xsd /usr/share/xsd
sudo chmod 644 /usr/share/xsd/cfint-*.xsd
popd
#
pushd $MSSCFHOME/cfcrm_2_12/java/
cd bin
cd xsd
cp -v cfcrm-*.xsd ~/bin/bin/xsd
chmod 644 ~/bin/bin/xsd/cfcrm-*.xsd
sudo cp -v cfcrm-*.xsd /usr/share/xsd
sudo chmod 644 /usr/share/xsd/cfcrm-*.xsd
popd
#
pushd $MSSCFHOME/cfacc_2_12/java/
cd bin
cd xsd
cp -v cfaccounting-*.xsd ~/bin/bin/xsd
chmod 644 ~/bin/bin/xsd/cfaccounting-*.xsd
sudo cp -v cfaccounting-*.xsd /usr/share/xsd
sudo chmod 644 /usr/share/xsd/cfaccounting-*.xsd
popd
#
pushd $MSSCFHOME/cfast_2_12/java/
cd bin
cd xsd
cp -v cfasterisk-*.xsd ~/bin/bin/xsd
chmod 644 ~/bin/bin/xsd/cfasterisk-*.xsd
sudo cp -v cfasterisk-*.xsd /usr/share/xsd
sudo chmod 644 /usr/share/xsd/cfasterisk-*.xsd
popd
#
pushd $MSSCFHOME/cffrsw_2_12/java/
cd bin
cd xsd
cp -v cffreeswitch-*.xsd ~/bin/bin/xsd
chmod 644 ~/bin/bin/xsd/cffreeswitch-*.xsd
sudo cp -v cffreeswitch-*.xsd /usr/share/xsd
sudo chmod 644 /usr/share/xsd/cffreeswitch-*.xsd
popd
#
pushd $MSSCFHOME/cfbam_2_12/java/
cd bin
cd xsd
cp -v cfbam-*.xsd ~/bin/bin/xsd
chmod 644 ~/bin/bin/xsd/cfbam-*.xsd
sudo cp -v cfbam-*.xsd /usr/share/xsd
sudo chmod 644 /usr/share/xsd/cfbam-*.xsd
popd
#
pushd $MSSCFHOME/cfuniv_2_12/cplus/
cd cfuniversexml210
cd libcfuniversexml
cd xsd
cp -v cfuniverse-*.xsd ~/bin/bin/xsd
chmod 644 ~/bin/bin/xsd/cfuniverse-*.xsd
sudo cp -v cfuniverse-*.xsd /usr/share/xsd
sudo chmod 644 /usr/share/xsd/cfuniverse-*.xsd
popd
