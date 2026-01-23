#!/bin/zsh

autoload -Uz zargs

setopt extended_glob

function zorglub
{
	eval ${1}
	
}

if [ $# -ne 1 ]
then
	echo "Erreur FATALE. Usage: ./find_paths_nonascii <répertoire>"
	echo "Par exemple: ./find_paths_nonascii /Volumes/PORSCHE/PHOTOGRAPHIES/___2023___"
	echo "Sortie immédiate"
	exit 1
fi
ROOT_DIR=${1}
echo ${ROOT_DIR}


# Le glob qualifier N sert à ce qu'il n'y ait pas d'erreur renvoyée quand il n'y a pas de match
toto="${1}/*/*/*/"
argument="\"${1}/*/*/*(N/Dod)\""

#for a in ${1}/*/*/*(N/Dod)

titi=$(eval echo ${toto})
echo "titi=$titi"

zargs -I arg -- ${1}/*/*/*/ -- echo arg

#zargs -I arg -- $(eval echo ${toto}) -- echo arg

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


for a in $(eval ls -d "${toto}")
do 
	echo "traitement du répertoire ${a}"
	if [[ ${a} = *[![:ascii:]]* ]]
	then 
		echo "Contain Non-ASCII: ${a}"
	fi
done
exit 0
