#!/bin/zsh
touch /tmp/totoblr.txt
for file in /Volumes/Thunderbolt5/BLR/BALOO_TRESORIER/SAISON_BLR_2026/Compta/LICENCES_2025_2026/CMDS_FFE/**/cmd*.pdf(.)
do
	/opt/homebrew/bin/pdfgrep "Elo:" ${file} >> /tmp/totoblr.txt
done
	
cut -b 49- /tmp/totoblr.txt | awk '{print $1}' | sort -u | wc -l
rm /tmp/totoblr.txt

exit 0
