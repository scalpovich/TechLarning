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
   ControlClick("Visa Test System","","[CLASS:Button; INSTANCE:36]") ; selecting value from Card Section - Default radio button
   ControlCommand("Visa Test System", "", "[CLASS:ComboBox; INSTANCE:7]", "SelectString", "AutomationTesting") ; selecting value from Card Section - from Default radio button section to select from dropdown
   ControlClick("Visa Test System","","[CLASS:Button; INSTANCE:48]")  ;pressing the OK