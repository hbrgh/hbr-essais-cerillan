#!/bin/zsh

setopt extended_glob

if [ $# -ne 1 ]
then
	echo "Erreur FATALE. Usage: ./find_paths_nonascii.zsh <répertoire>"
	echo "Par exemple: ./find_paths_nonascii.zsh /Volumes/PORSCHE/PHOTOGRAPHIES/___2023___"
	echo "Sortie immédiate"
	exit 1
fi
ROOT_DIR=${1}
echo ${ROOT_DIR}


# Le glob qualifier N sert à ce qu'il n'y ait pas d'erreur renvoyée quand il n'y a pas de match
for a in ${1}/**/*(N/Dod)
do 
	echo "traitement du répertoire ${a}"
	if [[ ${a} = *[![:ascii:]]* ]]
	then 
		echo "Contain Non-ASCII: ${a}"
	fi
done

exit 0

# ci-dessous x contiendra $faiailenamm sans les parenthèses
# ci-dessous y contiendra $x sans les blancs, remplacés par un tiret
for file in ${ROOT_DIR}/**/*(.)
do
	fououledir=$file:h
	faiailenamm=$file:t:r
	ext=$file:t:e
	x=${faiailenamm//[\(\)]/}
	y=`echo $x | sed -e 's/ /_/g'`
	nioufoulepaaaath="$fououledir/$y.${ext}"
	if ! [[ "$nioufoulepaaaath" == "$file" ]]
	then
		echo "$file renames to: $nioufoulepaaaath"
		mv $file $nioufoulepaaaath
	fi
done 
echo "ZE HAPPYYY ENDEU"
exit 0
