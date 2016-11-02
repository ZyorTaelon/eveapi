#!/bin/bash

if [ $# -ne 1 ]; then
  echo "Give filename as first parameter!"
  exit -1
fi

sed -i -e 's#assertEquals(\([^,]*\),[ ]*\([^,]*\));#assertThat(\2, equalTo(\1));#' \
       -e 's#assertNotNull(\(.*\));#assertThat(\1, notNullValue());#' \
       -e 's#assertNull(\(.*\));#assertThat(\1, nullValue());#' \
       -e 's#assertTrue(\(.*\));#assertThat(\1, equalTo(true));#' \
       -e 's#assertFalse(\(.*\));#assertThat(\1, equalTo(false));#' \
	$1
