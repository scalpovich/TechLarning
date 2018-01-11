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

   WinActivate("Variables Manager")
   sleep(2000)
   WinSetState("Variables Manager", "", @SW_MAXIMIZE)