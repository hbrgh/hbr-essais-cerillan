#!/bin/zsh

mostRecentYearComptesDir=$(ls -d /Volumes/Thunderbolt5/BRANCHES/BP/comptes/20*/ | sed 's:/*$::' | sort -r -k1.38,1.41 | head -1)
mostRecentYearComptes=$(basename $mostRecentYearComptesDir)
echo "mostRecentYearComptes:${mostRecentYearComptes}"


./ultra_moderne_nouvelle_instance_comptes.zsh ${mostRecentYearComptes} /Volumes/Thunderbolt5/BRANCHES/BP/comptes /Volumes/Thunderbolt5/SYNCBACK3_NDLG/NDLG


exit 0
