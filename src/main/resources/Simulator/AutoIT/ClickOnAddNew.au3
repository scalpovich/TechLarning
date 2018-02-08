WinActivate("MasterCard")
Local $aPos = ControlGetPos("MasterCard", "", "[NAME:toolStripBIN]")
Local $x = 15
Local $y = 30
MouseClick("left",$aPos[0] + $x, $aPos[1] + $y, 1)
ControlClick("MasterCard", "", "[CLASS:SysHeader32; INSTANCE:2]")
MouseClick("left",$aPos[0] + $x, $aPos[1] + $y, 1)
