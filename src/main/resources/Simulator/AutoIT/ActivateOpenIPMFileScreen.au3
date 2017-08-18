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

   sleep(2000)
	WinActivate("Open IPM File", "File &name:")
	sleep(500)

   $filedir =@ScriptDir ;Directory within the Appdata directory where the ini file should be.
   $filePath = StringReplace($filedir, "\Simulator\AutoIT", "")

	sleep(1000)
	ControlSetText("Open IPM File","","[CLASS:Edit; INSTANCE:1]","") ; erase the file name to make room for the $dest string
	sleep(1000)
    ControlSetText("Open IPM File","","[CLASS:Edit; INSTANCE:1]", $filePath) ; set the Edit1 text to the $dest and hit the button to swithc directories.
    sleep(1000)
    ControlClick("Open IPM File","","[CLASS:Button; INSTANCE:1]")
