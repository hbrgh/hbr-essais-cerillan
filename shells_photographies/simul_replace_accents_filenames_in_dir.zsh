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
	
î


#for file in ${ROOT_DIR}/**/*(.)
for file in ${ROOT_DIR}/**/^*.(zsh|sh)(.)
do
	fououledir=$file:h
	faiailenamm=$file:t:r
	if [[ ${faiailenamm} = *[![:ascii:]]* ]]
	then
		echo "$file contains no-ascii chars in its name"
		#echo $file ${file//à/a}
		file1=${file//à/a}
		#echo $file1  ${file1//À/A}
		file2=${file1//À/A}
		file3=${file2//ó/o}
		file4=${file3//é/e}
		file5=${file4//î/I}
		file6=${file5//è/e}
		file7=${file6//Ž/Z}
		file8=${file7//ô/o}
		file9=${file8//û/u}
		file10=${file9//ê/e}
		file11=${file10//ï/i}
		echo "$file will be renamed to $file11"

	fi
done
exit 0
