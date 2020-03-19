echo on

set WrapperPath="C:\Program Files\nssm-2.24\win64\nssm.exe"

set SrvName="MIBS-Cabinet-Agent"

set SrvDispName="MIBS-Cabinet-Agent"

set PathToProg=java.exe

set ProgParams="-Xmx400m"

set AppDir=d:\mibs-cabinet-agent

set AppName=mibs-cabinet-agent.jar

set AppParams=d:\mibs-cabinet-agent\config.properties

%WrapperPath% stop %SrvName%

%WrapperPath% remove %SrvName% confirm

%WrapperPath% install %SrvName% 

%PathToProg%  -jar %AppDir%\%AppName% %AppParams%

%WrapperPath%  set %SrvName% DisplayName %SrvDispName%

%WrapperPath% set %SrvName% AppDirectory %AppDir%

%WrapperPath% set %SrvName% AppRestartDelay 1000

%WrapperPath%  set %SrvName% Description “Start 

%PathToProg% with params %ProgParams% -jar \"%AppDir%\\%AppName%\" %AppParams%"
