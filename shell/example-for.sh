#!/bin/sh


# for 变量名 in 变量列表
# do
#    命令序列
# done

for index in `ls -h` 
do 
  echo "$index" 
done 


echo ">>>>>>>>>>>>>华丽的分隔符>>>>>>>>>>>>>>>>>>>>>>>>" 

filelist=$(ls -a)
for index in $filelist 
do 
  echo "$index \t \c "
done 


