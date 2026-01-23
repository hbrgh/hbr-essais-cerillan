#!/bin/zsh

for file in /Volumes/SAMSUNG_T5/BLR/BALOO_TRESORIER/SAISON_BLR_2026/Compta/LICENCES_2025_2026/CMDS_FFE/**/cmd*.pdf(.)
do
	/usr/local/bin/pdfgrep "Elo:" ${file}
done
	



exit 0
