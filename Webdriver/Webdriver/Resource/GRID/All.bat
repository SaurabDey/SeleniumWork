java -jar "D:\Grid\server.jar" -role node  -Dwebdriver.chrome.driver=D:\Grid\chromedriver.exe -browser browserName=chrome,maxInstances=3 -Dwebdriver.ie.driver=D:\Grid\IEDriverServer.exe -browser browserName=internetexplorer,maxInstances=3 -browser browserName=firefox,maxInstances=10 -hub http://localhost:4444/grid/register -port 8888
pause
