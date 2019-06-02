package com.barlingo.backend.utilities;

public final class RestError {

  private RestError() {
    throw new IllegalStateException("Utility class");
  }

  // General errors
  public static final String ANONYMIZE_PROCESS_ERROR = "Anonymize.ProcessError";

  // Establishment controller and service errors
  public static final String ALL_ESTABLISHMENT_MALFORMED_URL = "All.Establishment.MalformedURL";
  public static final String ALL_ESTABLISHMENT_DATE_NOTNULL = "User.Establishment.DateNotNull";
  public static final String ALL_ESTABLISHMENT_USERNAME_EXISTS = "All.Establishment.UsernameExists";
  public static final String UNSIGNED_ESTABLISHMENT_VALIDATION_ERRORS =
      "Unsigned.Establishment.ValidationErrors";
  public static final String UNSIGNED_ESTABLISHMENT_ERROR_SAVING_ESTABLISHMENT =
      "Unsigned.Establishment.ErrorSavingEstablishment";
  public static final String ESTABLISHMENT_ESTABLISHMENT_ERROR_SAVING_ESTABLISHMENT =
      "Establishment.Establishment.ErrorSavingEstablishment";
  public static final String USER_ESTABLISHMENT_NOT_FOUND = "User.Establishment.NotFound";
  public static final String USER_ESTABLISHMENT_FORBIDEN_ACCESS =
      "User.Establishment.ForbidenAccess";
  public static final String ESTABLISHMENT_ESTABLISHMENT_UPLOAD_FILE_IO =
      "Establishment.Establishment.UploadFileIO";
  public static final String ESTABLISHMENT_ESTABLISHMENT_NOT_NULL =
      "Establishment.Establishment.NotNull";
  public static final String ESTABLISHMENT_ESTABLISHMENT_NOT_FOUND =
      "Establishment.Establishment.NotFound";
  public static final String ESTABLISHMENT_ESTABLISHMENT_CANNOT_MODIFY_OTHER_USER =
      "Establishment.Establishment.CannotModifyOtherUser";
  public static final String ESTABLISHMENT_ESTABLISHMENT_CANNOT_ACCESS_OTHER_USERS_DATA =
      "Establishment.Establishment.CannotAccessOtherUsersData";
  public static final String ESTABLISHMENT_ESTABLISHMENT_ESTABLISHMENT_DATA_NOT_NULL =
      "Establishment.Establishment.EstablishmentDataNotNull";
  public static final String ESTABLISHMENT_ESTABLISHMENT_UNKNOWN_FILETYPE =
      "Establishment.Establishment.UnknownFileType";
  public static final String ESTABLISHMENT_ESTABLISHMENT_VALIDATION_ERRORS =
      "Establishment.Establishment.ValidationErrors";
  public static final String ESTABLISHMENT_ESTABLISHMENT_SECRET_NOT_EMPTY =
      "Establishment.Establishment.SecretNotEmpty";
  public static final String SIGNED_ESTABLISHMENT_ERROR_LOADING_IMAGE =
      "Signed.Establishment.ErrorLoadingImage";

  // User controller and service errors
  public static final String ALL_USER_USERNAME_EMPTY = "All.User.UsernameEmpty";
  public static final String ALL_USER_USERNAME_EXISTS = "All.User.UsernameExists";
  public static final String UNSIGNED_WRONG_USERNAME_OR_PASS = "Unsigned.User.WrongUsernameOrPass";
  public static final String USER_USER_UPLOAD_FILE_IO = "User.User.UploadFileIO";
  public static final String USER_USER_MALFORMED_URL = "User.User.MalformedURL";
  public static final String USER_USER_UNKNOWN_FILETYPE = "User.User.UnknownFileType";
  public static final String USER_USER_VALIDATION_ERRORS = "User.User.ValidationErrors";
  public static final String USER_USER_NOT_FOUND = "User.User.NotFound";
  public static final String USER_USER_ERROR_SAVING_USER = "User.User.ErrorSavingUser";
  public static final String USER_USER_CANNOT_MODIFY_OTHER_USERS =
      "User.User.CannotModifyOtherUsers";
  public static final String USER_USER_CANNOT_ACCESS_OTHER_USERS_DATA =
      "User.User.CannotAccessOtherUsersData";
  public static final String USER_USER_SECRET_NOT_EMPTY = "User.User.SecretNotEmpty";

  // Upload file service service errors
  public static final String ALL_UPLOADFILE_CANNOT_LOAD_IMAGE = "All.UploadFile.CannotLoadImage";

  // LanguageExchange controller and service errors
  public static final String ALL_LANGUAGE_EXCHANGE_NOT_NULL = "All.LanguageExchange.NotNull";
  public static final String USER_LANGUAGE_EXCHANGE_USER_NOT_NULL =
      "User.LanguageExchange.UserNotNull";
  public static final String SIGNED_LANGUAGE_EXCHANGE_NOT_FOUND =
      "Signed.LanguageExchange.NotFound";
  public static final String SIGNED_LANGUAGE_EXCHANGE_USER_NOT_EXISTS =
      "Signed.LanguageExchange.UserNotExists";
  public static final String SIGNED_LANGUAGE_EXCHANGE_USER_NOT_NULL =
      "Signed.LanguageExchange.UserNotNull";
  public static final String SIGNED_LANGUAGE_EXCHANGE_ESTABLISHMENT_NOT_EXISTS =
      "Signed.LanguageExchange.EstablishmentNotExists";
  public static final String USER_LANGUAGE_EXCHANGE_ESTABLISHMENT_NOT_NULL =
      "User.LanguageExchange.EstablishmentNotNull";
  public static final String USER_LANGUAGE_EXCHANGE_USER_NOT_FOUND =
      "User.LanguageExchange.UserNotFound";
  public static final String USER_LANGUAGE_EXCHANGE_CANNOT_MODIFY_OTHER_USERS =
      "User.LanguageExchange.CannotModifyOtherUsers";
  public static final String USER_LANGUAGE_EXCHANGE_EVENT_FINALIZED =
      "User.LanguageExchange.EventFinalized";
  public static final String USER_LANGUAGE_EXCHANGE_ALREADY_REGISTERED =
      "User.LanguageExchange.AlreadyRegistered";
  public static final String USER_LANGUAGE_EXCHANGE_USER_NOT_REGISTERED =
      "User.LanguageExchange.UserNotRegistered";
  public static final String USER_LANGUAGE_EXCHANGE_CANNOT_SAVE_PAST_EXCHANGE =
      "User.LanguageExchange.CannotSavePastExchange";
  public static final String USER_LANGUAGE_EXCHANGE_IS_FULL = "User.LanguageExchange.IsFull";
  public static final String USER_LANGUAGE_EXCHANGE_ERROR_SAVING_EXCHANGE =
      "User.LanguageExchange.ErrorSavingExchange";

  // Payment controller and service errors
  public static final String ESTABLISHMENT_PAYMENT_IO = "Establishment.Payment.IO";
  public static final String ESTABLISHMENT_PAYMENT_ORDER_ID_NOT_NULL =
      "Establishment.Payment.OrderIdNotNull";
  public static final String ESTABLISHMENT_PAYMENT_ESTABLISHMENT_NOT_EXISTS =
      "Establishment.Payment.EstablishmentNotExists";
  public static final String ESTABLISHMENT_PAYMENT_ESTABLISHMENT_ALREADY_HAVES_SUBSCRIPTION =
      "Establishment.Payment.EstablishmentAlreadyHavesSubscription";
  public static final String ESTABLISHMENT_PAYMENT_ERROR_PROCESING_ORDER =
      "Establishment.Payment.ErrorProcesingOrder";
  public static final String ESTABLISHMENT_PAYMENT_ERROR_PROCESING_SUBSCRIPTION =
      "Establishment.Payment.ErrorProcesingSubscription";
  public static final String ESTABLISHMENT_PAYMENT_ORDER_IS_NOT_VALID =
      "Establishment.Payment.OrderIsNotValid";
  public static final String ESTABLISHMENT_PAYMENT_ORDER_BELONGS_TO_ANOTHER_SUBSCRIPTION =
      "Establishment.Payment.OrderBelongsToAnotherSubscription";
  public static final String ESTABLISHMENT_PAYMENT_ERROR_PARSING_DATE =
      "Establishment.Payment.ErrorParsingDate";
  public static final String ESTABLISHMENT_PAYMENT_ERROR_SAVING_PAYDATA =
      "Establishment.Payment.ErrorSavingPaydata";
  public static final String ESTABLISHMENT_PAYMENT_ERROR_SAVING_SUBSCRIPTION_DATA =
      "Establishment.Payment.ErrorSavingSubscriptionData";
  public static final String ESTABLISHMENT_PAYMENT_ERROR_SAVING_ESTABLISHMENT =
      "Establishment.Payment.ErrorSavingEstablishment";
  public static final String ESTABLISHMENT_PAYMENT_PAYDATA_NOT_NULL =
      "Establishment.Payment.ErrorPayDataNotNull";

  // UserDiscount controller and service errors
  public static final String SIGNED_USERDISCOUNT_CODE_NOT_VALID =
      "Signed.UserDiscount.CodeNotValid";
  public static final String SIGNED_USERDISCOUNT_CODE_NOT_EXISTS =
      "Signed.UserDiscount.CodeNotExists";
  public static final String SIGNED_USERDISCOUNT_USER_NOT_EXISTS =
      "Signed.UserDiscount.UserNotExists";
  public static final String SIGNED_USERDISCOUNT_USER_NOT_NULL = "Signed.UserDiscount.UserNotNull";
  public static final String SIGNED_USERDISCOUNT_USERDISCOUNT_NOT_NULL =
      "Signed.UserDiscount.UserDiscountNotNull";
  public static final String SIGNED_USERDISCOUNT_ESTABLISHMENT_NOT_NULL =
      "Signed.UserDiscount.EstablishmentNotNull";
  public static final String SIGNED_USERDISCOUNT_ACCESS_FORBIDDEN =
      "Signed.UserDiscount.AccessForbidden";
  public static final String SIGNED_USERDISCOUNT_NOT_VISIBLE = "Signed.UserDiscount.NotVisible";
  public static final String SIGNED_USERDISCOUNT_LANGUAGE_EXCHANGE_NOT_NULL =
      "Signed.UserDiscount.LanguageExchangeNotNull";
  public static final String SIGNED_USERDISCOUNT_LANGUAGE_EXCHANGE_NOT_EXITS =
      "Signed.UserDiscount.LanguageExchangeNotExists";
  public static final String ESTABLISHMENT_USERDISCOUNT_LANGUAGE_EXCHANGE_NOT_STARTED_YET =
      "Signed.UserDiscount.LanguageExchangeNotStartedYet";
  public static final String ESTABLISHMENT_USERDISCOUNT_CANNOT_BE_EXCHANGED =
      "Establishment.UserDiscount.UserDiscountCannotBeExchanged";
  public static final String SIGNED_USERDISCOUNT_ERROR_SAVING_DISCOUNT =
      "Signed.UserDiscount.ErrorSavingDiscount";
  public static final String SIGNED_USERDISCOUNT_CODE_BELONG_ANOTHER_EXCHANGE =
      "Signed.UserDiscount.CodeBelongOtherExchange";
  public static final String SIGNED_USERDISCOUNT_CODE_BELONG_OTHER_ESTABLISHMENT =
      "Signed.UserDiscount.CodeBelongOtherStablishment";
  public static final String ESTABLISHMENT_USERDISCOUNT_ERROR_UPDATING_DISCOUNT =
      "Establishment.UserDiscount.ErrorUpdatingDiscount";

  // UserAccount service errors
  public static final String SIGNED_USERACCOUNT_NOT_NULL = "Signed.UserAccount.NotNull";
  public static final String SIGNED_USERACCOUNT_SECRET_EMPTY = "Signed.UserAccount.SecretEmpty";
  public static final String SIGNED_USERACCOUNT_NOT_EXISTS = "Signed.UserAccount.NotExists";
  public static final String SIGNED_USERACCOUNT_ERROR_DECODING = "Signed.UserAccount.ErrorDecoding";
  public static final String SIGNED_USERACCOUNT_ERROR_SAVING_ACCOUNT =
      "Signed.UserAccount.ErrorSavingAccount";

  // Assessment service errors
  public static final String SIGNED_ASSESSMENT_USER_OR_ASSESSEDUSER_NOT_MATCH_IN_SAME_EXCHANGE =
      "Signed.Assessment.UserAndAssseduserNotMatchInSameExchange";
  public static final String SIGNED_ASSESSMENT_EXCHANGE_MOMENT_NOT_PAST =
      "Signed.Assessment.ExchangeMomentIsNotPast";
  public static final String SIGNED_ASSESSMENT_USER_AND_ASSESSEDUSER_MUST_NOT_BE_SAME =
      "Signed.Assessment.UserAndAssessedUserNotBeSame";


}
