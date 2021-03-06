#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#include <MsgBoxConstants.au3>
#include <WinAPIFiles.au3>
#include <Constants.au3>

   $CmdLine[0]
   $CmdLine[1]
	WinActivate("Import Test Suite from Text File", "Files of &type:")
	sleep(500)

   $filePath = $CmdLine[$CmdLine[0]] ;Directory within the Appdata directory where the ini file should be.

	ControlSetText("Import Test Suite from Text File","","[CLASS:Edit; INSTANCE:1]", $filePath) ; erase the file name to make room for the $dest string
	sleep(1000)

    ControlClick("Import Test Suite from Text File","","[CLASS:Button; INSTANCE:1]")
    sleep(2000)

    WinWait("Import Transaction File", "Row Description", "30")

	WinActivate("Import Transaction File", "Row Description")
	 sleep(1000)
	ControlClick("Import Transaction File","","[NAME:Cmd_OK]")

	WinActivate("Import Transaction File", "Cancel")
	 sleep(1000)
	ControlClick("Import Transaction File","","[NAME:cmd_Cancel]")

  if WinExists("MasterINQ_ImportTrxFile / ImportTrxFile()", "OK") Then
	WinActivate("MasterINQ_ImportTrxFile / ImportTrxFile()", "OK")
	 sleep(1000)
	ControlClick("MasterINQ_ImportTrxFile / ImportTrxFile()","","Button1")
EndIf