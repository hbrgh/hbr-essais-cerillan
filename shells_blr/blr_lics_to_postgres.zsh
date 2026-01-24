#!/bin/zsh

cleanup() {
	rm -f /tmp/lics.csv
	
}


trap cleanup EXIT






psql -p 8611 "dbname='licences' user='blr'" -c "DROP TABLE lics_2026;"

psql -p 8611 "dbname=licences user=blr" -f /Users/herve/NOUV_ARARAT_DEV_PERSO/POSTGRES_HERVE_PERSO/SERVEUR/MANIPS_BLR_JANV_2026/TABLES_DB_LICENCES/create_table_lics.sql



./list_blr_lic_csv_final.zsh > /tmp/lics.csv

psql -p 8611 "dbname='licences' user='blr'" -c "COPY lics_2026(nom,no_lic,date_naissance,type_lic,categorie,elo) FROM '/tmp/lics.csv'  DELIMITER ';' CSV HEADER;"





echo "SUCCES"

exit 0
