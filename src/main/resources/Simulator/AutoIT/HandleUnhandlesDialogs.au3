#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#RequireAdmin
#include <MsgBoxConstants.au3>
#include <WinAPIFiles.au3>
#include <Constants.au3>

    WinActivate("Import Merchant Profiles", "Row Description")
	 sleep(1000)
	ControlClick("Import Merchant Profiles","","[NAME:Cmd_OK]")

	WinActivate("Import Transaction File", "Row Description")
	 sleep(1000)
	ControlClick("Import Transaction File","","[NAME:Cmd_OK]")

	WinActivate("Import Transaction File", "Cancel")
	 sleep(1000)
	ControlClick("Import Transaction File","","[NAME:cmd_Cancel]")

    WinActivate("MasterINQ_ImportTrxFile / ImportTrxFile()", "OK")
	 sleep(1000)
	ControlClick("MasterINQ_ImportTrxFile / ImportTrxFile()","","Button1")

	 WinActivate("Import Card Profiles", "Row Description")
   sleep(1000)
   ControlClick("Import Card Profiles","","[NAME:Cmd_OK]")

   WinActivate("C:\Program Files (x86)\MasterCard\MCPS 16_Q4\mcps.exe", "OK")
   ControlClick("C:\Program Files (x86)\MasterCard\MCPS 16_Q4\mcps.exe","","[CLASS:Button; INSTANCE:1]")

   WinActivate("View Downloads - Internet Explorer", "")