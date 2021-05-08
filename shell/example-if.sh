#!/bin/bash
# this is test file

# 创建文件  属于if的单分支结构
if [ ! -e example-if.sh ]
 then
 touch example-if.sh
fi


# 判断文件是否存在，  属于if的双分支结构

if [ ! -f example-if.sh ]
  then 
  echo "这是一个sh文件" 
else
  echo "是false显示内容，这不是个一般文件"
fi




