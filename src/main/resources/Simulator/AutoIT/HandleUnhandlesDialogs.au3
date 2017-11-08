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

    WinActivate("Import Merchant Profiles", "Row Description")
	ControlClick("Import Merchant Profiles","","[NAME:Cmd_OK]")

	WinActivate("Import Transaction File", "Row Description")
	ControlClick("Import Transaction File","","[NAME:Cmd_OK]")

	WinActivate("Import Transaction File", "Row Description")
	ControlClick("Import Transaction File","","[NAME:cmd_Cancel]")

    WinActivate("MasterINQ_ImportTrxFile / ImportTrxFile()", "OK")
	ControlClick("MasterINQ_ImportTrxFile / ImportTrxFile()","","Button1")

   WinActivate("Import Card Profiles", "Row Description")
   ControlClick("Import Card Profiles","","[NAME:Cmd_OK]")

    WinActivate("Import Card Profiles", "Row Description")
   ControlClick("Import Card Profiles","","[NAME:cmd_Cancel]")

   WinActivate("C:\Program Files (x86)\MasterCard\MCPS 16_Q4\mcps.exe", "OK")
   ControlClick("C:\Program Files (x86)\MasterCard\MCPS 16_Q4\mcps.exe","","[CLASS:Button; INSTANCE:1]")

   WinActivate("View Downloads - Internet Explorer", "")