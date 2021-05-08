#!/bin/bash
# this is test file 

if [[ -d /etc/fstab ]];then
    echo "不存在"
else
    echo "存在"
fi

# 变量可以是一个命令的输出内容
FILELIST=$(ls -a /etc/)
for i in $FILELIST
do
  echo "$i \t \c"
done


