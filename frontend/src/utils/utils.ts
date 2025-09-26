export const formatBoolean = (truthy: boolean) => {
  return truthy ? 'Y' : 'N';
};

export const formatCombo = (truthy: boolean) => {
  return truthy ? 'C' : 'S';
};

export const formatDateToLocal = (
  dateStr: string,
  locale: string = 'en-US',
) => {
  const date = new Date(dateStr);
  const options: Intl.DateTimeFormatOptions = {
    day: 'numeric',
    month: 'short',
    year: 'numeric',
  };
  const formatter = new Intl.DateTimeFormat(locale, options);
  return formatter.format(date);
};

export const formatDateAsISO = (
  dateStr: string,
  locale: string = 'en-US',
) => {
  const date = new Date(dateStr);
  return date.toLocaleDateString(locale)
};