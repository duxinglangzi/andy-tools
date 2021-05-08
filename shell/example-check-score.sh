#!/bin/sh

read -p "请输入分数(0-100):" GARDE
if [ $GARDE -ge 85 ] && [ $GARDE -le 100 ]; then 
  echo "$GARDE is excellent"
elif [ $GARDE -ge 70 ] && [ $GARDE -le 85 ]; then 
  echo "$GARDE 通过"
else 
  echo "$GARDE 挂科"
fi



