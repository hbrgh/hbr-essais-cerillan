#!/bin/zsh

if [ $# -ne 3 ]
then
	echo "Erreur FATALE. Usage: ./ultra_moderne_nouvelle_instance_comptes.sh <année> <repComptes> <repNDLG>"
	echo "Par exemple: ./ultra_moderne_nouvelle_instance_comptes.sh 2023 /Volumes/Thunderbolt5/BRANCHES/BP/comptes /Volumes/Thunderbolt5/SYNCBACK3/GESTION_PERSO/NDLG"
	echo "Sortie immédiate"
	exit 1
fi


repNDLG=${3}
repComptes=${2}
lengthRepComptes=${#repComptes}
echo "lengthRepComptes=$lengthRepComptes"



year=${1}
# mostRecentDir=$(ls -d ${repComptes}/${year}/*${year} | sort -r -k1.45,1.46 -k1.43,1.44 | head -1)
posDebSecTri=$((${lengthRepComptes}+7))
echo "posDebSecTri=$posDebSecTri"
posFinSecTri=$((posDebSecTri+1))
echo "posFinSecTri=$posFinSecTri"
posDebPremTri=$((posFinSecTri+1))
echo "posDebPremTri=$posDebPremTri"
posFinPremTri=$((posDebPremTri+1))
echo "posFinPremTri=$posFinPremTri"



mostRecentDir=$(ls -d ${repComptes}/${year}/*${year} | sort -r -k1.${posDebPremTri},1.${posFinPremTri} -k1.${posDebSecTri},1.${posFinSecTri} | head -1)
echo "mostRecentDir=$mostRecentDir"
lengthMostRecentDir=${#mostRecentDir}
echo "lengthMostRecentDir=$lengthMostRecentDir"


diffLenMostRecentDirLenRespComptes=$(($lengthMostRecentDir-$lengthRepComptes))
echo "diffLenMostRecentDirLenRespComptes=$diffLenMostRecentDirLenRespComptes"



# Contrôle
# La différence en nombre de caractères entre 
# /Volumes/Thunderbolt5/BRANCHES/BP/comptes/2023/30072023 et /Volumes/Thunderbolt5/BRANCHES/BP/comptes est de 14.
# Ca vaudrait 14 également si le répertoire de base pour les comptes était autre que /Volumes/Thunderbolt5/BRANCHES/BP/comptes
valAttendueDiff=14
if [ $diffLenMostRecentDirLenRespComptes -ne $valAttendueDiff ]
then
	echo "Erreur FATALE: diffLenMostRecentDirLenRespComptes vaut $diffLenMostRecentDirLenRespComptes et pas la valeur attendue $valAttendueDiff"
	echo "Sortie immédiate" 
	exit 1
fi



nouvNameDirRepComptes=$(date +"%d%m%Y")
echo "nouvNameDirRepComptes=$nouvNameDirRepComptes"

#fullPathParentDirComptes=$(dirname $mostRecentDir)
#echo "fullPathParentDirComptes=$fullPathParentDirComptes"


nameDirComptes=$(basename $mostRecentDir)
echo "nameDirComptes=$nameDirComptes"
rootFileNameYYYY=$(echo ${nouvNameDirRepComptes} | cut -b5-8)
echo "rootFileNameYYYY=$rootFileNameYYYY"






oldRootFileNameJJ=$(echo ${nameDirComptes} | cut -b1,2)
oldRootFileNameMM=$(echo ${nameDirComptes} | cut -b3,4)
oldRootFileNameYYYY=$(echo ${nameDirComptes} | cut -b5-8)



patternOldDateFile="${oldRootFileNameJJ}_${oldRootFileNameMM}_${oldRootFileNameYYYY}"
echo "patternOldDateFile=$patternOldDateFile"
patternNewDateFile=$(date +"%d_%m_%Y")
echo "patternNewDateFile=$patternNewDateFile"



fullPathDirRepComptes="${repComptes}/${rootFileNameYYYY}"
if ! [ -d "$fullPathDirRepComptes" ]
then
	echo "Création de ${fullPathDirRepComptes}..."
	mkdir -p ${fullPathDirRepComptes}
fi


nouvDirComptes=${fullPathDirRepComptes}/${nouvNameDirRepComptes}
echo "nouvDirComptes=$nouvDirComptes"
cp -r ${mostRecentDir} ${nouvDirComptes}
echo "${nouvDirComptes} créé avec succès"
cd ${nouvDirComptes}
rm -rf NDLG
rm *.pdf



# Ici, attention, c'est du pur zsh
for file in ./${patternOldDateFile}.*(.)
do 
	mv $file ./${patternNewDateFile}.${file:e}	
done

echo "Copie de NDLG dans ${nouvDirComptes}"
cp -pr ${repNDLG} ${nouvDirComptes}


exit 0
