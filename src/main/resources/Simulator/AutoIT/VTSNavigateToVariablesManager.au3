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

   WinActivate("Visa Test System")
   WinMenuSelectItem("Visa Test System", "", "&Edit", "&Variables Manager...")

   WinWaitActive("Variables Manager","", "100")

   WinSetState("Variables Manager", "", @SW_MAXIMIZE)

   WinMenuSelectItem("Variables Manager", "", "&File", "&Import from Excel Document")
   sleep(4000)

   ControlSetText("Open","","[CLASS:Edit; INSTANCE:1]", $CmdLine[1]) ; setting text in the path section
   sleep(1000)
   ControlClick("Open","","[CLASS:Button; INSTANCE:1]") ; click on Open button
   sleep(6000)

   ControlClick("Variables Manager","","[CLASS:Button; INSTANCE:1]")  ;pressing the OK dialog on successful import dialog

   WinSetState("Variables Manager", "", @SW_MINIMIZE ) ; mimimizing window