#!/bin/zsh

cleanup() {
	rm -f $TMPFILE1
	rm -f $TMPFILE2
	rm -f $TMPFILE3
}

mizDateNaissanceFormatPostgres() {
	for line in "${(@f)"$(<$1)"}"
	{
		parts=(${(@s:;:)line})
		for ((i = 1; i <= $#parts; i++))
		do
			if [[ $i -eq 4 ]]
			then
				continue;
			fi
			if [[ $i -eq 6 ]]
			then
				continue;
			fi
			if [[ $i -eq 2 ]]
			then
				zozo=$(date -j -f "%d/%m/%Y" $parts[i] "+%Y-%m-%d")
				print -n $zozo
			else
				print -n $parts[i] 
			fi
			if [[ $i -ne $#parts ]]
			then
				print -n ";"
			fi
			
		done
	
		echo
		#echo $parts
	}
}


trap cleanup EXIT


tempfoo=`basename $0`
TMPFILE1=`mktemp -q /tmp/${tempfoo}.XXXXXX1`
if [ $? -ne 0 ]; then
	echo "$0: Can't create temp file, exiting..."
	exit 1
fi
./list_blr_lic.zsh | sort -k 2 | awk -FRap '{print $1";"}' | cut -c1-43 | sed 's/^[ \t]*//;s/[ \t]*$//' | awk '{print $0 ";"}' > ${TMPFILE1}

TMPFILE2=`mktemp -q /tmp/${tempfoo}.XXXXXX2`
if [ $? -ne 0 ]; then
	echo "$0: Can't create temp file, exiting..."
	exit 1
fi
./list_blr_lic.zsh | sort -k 2 | awk -FRap '{print $1}' | cut -c44- | sed 's/^[ \t]*//;s/[ \t]*$//' | awk '{$1=$1}1' | sed 's/[[:space:]]\{1,\}/;/g' > ${TMPFILE2}







TMPFILE3=`mktemp -q /tmp/${tempfoo}.XXXXXX3`
if [ $? -ne 0 ]; then
	echo "$0: Can't create temp file, exiting..."
	exit 1
fi
mizDateNaissanceFormatPostgres ${TMPFILE2} > ${TMPFILE3}

paste ${TMPFILE1} ${TMPFILE3} | awk '{$1=$1}1' | sed 's/;[[:space:]]\{1,\}/;/g' | tail -r | awk -F \; '!(a[$2]++)' |  tail -r



exit 0
