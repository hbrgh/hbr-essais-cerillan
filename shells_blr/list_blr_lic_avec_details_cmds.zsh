#!/bin/zsh

for file in /Volumes/Thunderbolt5/BLR/BALOO_TRESORIER/SAISON_BLR_2026/Compta/LICENCES_2025_2026/CMDS_FFE/**/cmd*.pdf(.)
do
	echo
	echo "${file}: DEBUT"
	/opt/homebrew/bin/pdfgrep "Elo:" ${file}
	echo "${file}: FIN"
	echo
done
	



exit 0
