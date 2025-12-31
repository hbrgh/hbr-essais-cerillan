#!/bin/zsh

mostRecentYearComptesDir=$(ls -d /Volumes/SAMSUNG_T5/BRANCHES/BP/comptes/20*/ | sed 's:/*$::' | sort -r -k1.38,1.41 | head -1)
mostRecentYearComptes=$(basename $mostRecentYearComptesDir)
echo "mostRecentYearComptes:${mostRecentYearComptes}"


./ultra_moderne_nouvelle_instance_comptes.zsh ${mostRecentYearComptes} /Volumes/SAMSUNG_T5/BRANCHES/BP/comptes /Volumes/SAMSUNG_T5/SYNCBACK3_NDLG/NDLG


exit 0
