Add 3D E-Commerce Security Parameters

Narrative:
In order to make 3 d secure transaction
As an issuer
I want to create 3d e-commerce security parameters setup

Meta:
@UI
@all
@StoryName AddThreeDSecureParameters

Scenario:add 3d e-commerce security parameters for prepaid

Meta:
@TCName TCInstituteCreationPR
@testDataFileName testdata
@sheetName Institute 
Given login to bank as a customerUser
When user adds 3D ecommerce security parameters for prepaid

Scenario:add 3d e-commerce security parameters for debit

Meta:
@TCName TCInstituteCreationPR
@testDataFileName testdata
@sheetName Institute 
Given login to bank as a customerUser
When user adds 3D ecommerce security parameters for debit

Scenario:add 3d e-commerce security parameters for credit

Meta:
@TCName TCInstituteCreationPR
@testDataFileName testdata
@sheetName Institute 
Given login to bank as a customerUser
When user adds 3D ecommerce security parameters for credit