#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#include <MsgBoxConstants.au3>
#include <WinAPIFiles.au3>
#include <Date.au3>
#include <File.au3>
#include <MsgBoxConstants.au3>

   Local $sDate = _NowCalcDate();
   Local $sTodaysDate =  StringReplace($sDate, "/", "")
   ; Generate a unique filename in @TempDir
   Local $sTempFile_1 = @TempDir() &"\" & $sTodaysDate &"_IssuingTests_Simulator";
   DirCreate ($sTempFile_1);



	WinActivate("PIN Offset Calculator", "Card Number :")
	Local $sText = ControlGetText ("PIN Offset Calculator", "", "[CLASS:Static; INSTANCE:14]")

   $filedir =$sTempFile_1 ;;Directory in Temp Folder
   $filename = "PINData.txt" ;Ini file name.

   $filePath = $filedir & "\" & $filename

    ; Delete the temporary file.
    FileDelete($filePath)

	FileWrite($filePath, $sText)