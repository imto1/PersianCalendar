def split_date(datestr):
    date = datestr.split("/")
    if len(date) < 2:
        date = datestr.split("-")
    return date