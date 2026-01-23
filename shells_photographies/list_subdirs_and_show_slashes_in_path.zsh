#!/bin/zsh

function compter_slashes
{
#	echo ${1}
	count=$((${#${(s./.)${1}}}-1))
	
	if [[ ${1[1,1]} == "/" ]]
	then 
		((count++))
	fi
	echo $count

}

if [ $# -ne 1 ]
then
	echo "Erreur FATALE. Usage: ./list_subdirs_and_show_slashes_in_path.zsh <répertoire>"
	echo "Sortie immédiate"
	exit 1
fi
ROOT_DIR=${1}



# Le glob qualifier N sert à ce qu'il n'y ait pas d'erreur renvoyée quand il n'y a pas de match
for a in ${1}/**/*(N/Dod)
do
	#echo ${a}
	#count=$((${#${(s./.)${a}}}-1))
	#echo $count
	count=$(compter_slashes ${a})
	echo "${a}: $count slashes"
done

#zargs -I arg -- ${1}/**/*/ -- echo arg

exit 0
