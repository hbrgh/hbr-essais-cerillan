#!/bin/zsh

setopt extended_glob

if [ $# -ne 1 ]
then
	echo "Erreur FATALE. Usage: ./simul_find_non_ascii_filenames_in_dir.zsh <répertoire>"
	echo "Par exemple: ./simul_find_non_ascii_filenames_in_dir.zsh /Volumes/PORSCHE/PHOTOGRAPHIES/___2023___"
	echo "Sortie immédiate"
	exit 1
fi
ROOT_DIR=${1}
echo ${ROOT_DIR}



#for file in ${ROOT_DIR}/**/^*.(zsh|sh)(.)
#do
#	ext=$file:t:e
#	echo ${ext}
#	echo ${file}
#done
	



#for file in ${ROOT_DIR}/**/*(.)
for file in ${ROOT_DIR}/**/^*.(zsh|sh)(.)
do
	fououledir=$file:h
	faiailenamm=$file:t:r
	if [[ ${faiailenamm} = *[![:ascii:]]* ]]
	then
		echo "$file contains no-ascii chars in its name"
	fi
done
exit 0
